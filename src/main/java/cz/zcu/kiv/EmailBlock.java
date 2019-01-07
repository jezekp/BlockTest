package cz.zcu.kiv;

import cz.zcu.kiv.WorkflowDesigner.Annotations.BlockExecute;
import cz.zcu.kiv.WorkflowDesigner.Annotations.BlockType;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/***********************************************************************************************************************
 *
 * This file is part of the BlockTest project

 * ==========================================
 *
 * Copyright (C) 2018 by University of West Bohemia (http://www.zcu.cz/en/)
 *
 ***********************************************************************************************************************
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 ***********************************************************************************************************************
 *
 * EmailBlock, 2018/07/18 14:22 petr-jezek
 *
 **********************************************************************************************************************/
@BlockType(type = "Email", family = "Email")
public class EmailBlock {

    @BlockExecute
    public String execute() {

        final String user = "";
        final String password = "";
        try {
            Properties properties;
            properties = System.getProperties();
            properties.setProperty("mail.smtp.host", "smtp.zcu.cz");
            properties.put("mail.smtp.port", "25");
            //properties.put("mail.smtp.auth", "true");
            properties.setProperty("mail.user", user);
            properties.setProperty("mail.password", password);


            /**
             * Send an email.
             * @param toAddresses recipient
             * @param subject subject
             * @param text text of email
             * @throws MessagingException
             */

            Session session = Session.getDefaultInstance(properties, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(user, password);
                }
            });


            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress("jezekp@kiv.zcu.cz"));
            message.addRecipients(Message.RecipientType.TO, InternetAddress.parse("jezekp@kiv.zcu.cz"));
            ;
            message.setSubject("test");
            message.setText("TestEmail");

            Transport.send(message);
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
        return "ok";
    }


}
