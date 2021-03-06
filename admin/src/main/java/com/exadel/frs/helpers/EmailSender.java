/*
 * Copyright (c) 2020 the original author or authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package com.exadel.frs.helpers;

import com.exadel.frs.exception.UnreachableEmailException;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSender {

    @Value("${spring.mail.sender}")
    private String frsEmail;

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendMail(final String to, final String subject, final String message) {
        val msg = new SimpleMailMessage();
        msg.setTo(to);
        msg.setFrom(frsEmail);
        msg.setSubject(subject);
        msg.setText(message);

        try {
            javaMailSender.send(msg);
        } catch (MailException e) {
            throw new UnreachableEmailException(to);
        }
    }
}