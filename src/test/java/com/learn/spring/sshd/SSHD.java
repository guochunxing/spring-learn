package com.learn.spring.sshd;

import org.apache.sshd.client.SshClient;
import org.apache.sshd.client.channel.ChannelShell;
import org.apache.sshd.client.channel.ClientChannel;
import org.apache.sshd.client.channel.ClientChannelEvent;
import org.apache.sshd.client.session.ClientSession;
import org.apache.sshd.common.channel.PtyMode;
import org.apache.sshd.common.util.io.NoCloseInputStream;
import org.apache.sshd.common.util.io.NoCloseOutputStream;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Author: chunxing
 * Date: 2018/7/22  上午11:45
 * Description:
 */
public class SSHD {

    public static void main(String[] args) throws IOException {
        SshClient client = SshClient.setUpDefaultClient();
        client.start();
        ClientSession session = client.connect("abee", "127.0.0.1", 22).verify(500).getSession();
        session.addPasswordIdentity("guochunxing");
        session.auth().verify(1000);

        try (ChannelShell channel = (ChannelShell) session.createChannel(ClientChannel.CHANNEL_SHELL)) {
            channel.setAgentForwarding(true);
            channel.setPtyType("xterm");
            channel.setPtyColumns(160);
            channel.setPtyLines(50);
            channel.setPtyWidth(0);
            channel.setPtyHeight(0);
            Map<PtyMode, Integer> ptyModes = new HashMap<>();
            ptyModes.put(PtyMode.TTY_OP_OSPEED, 38400);
            ptyModes.put(PtyMode.TTY_OP_ISPEED, 38400);
            channel.setPtyModes(ptyModes);
            channel.setIn(new NoCloseInputStream(System.in));
            channel.setOut(new NoCloseOutputStream(System.out));
            channel.setErr(new NoCloseOutputStream(System.err));
            channel.open();
            System.out.println(channel.getProperties());
            channel.waitFor(Collections.singletonList(ClientChannelEvent.CLOSED), 0);
        } finally {
            session.close(false);
        }
    }

}
