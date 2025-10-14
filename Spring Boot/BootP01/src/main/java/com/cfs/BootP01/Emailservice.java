package com.cfs.BootP01;

import org.springframework.stereotype.Service;

@Service
public class Emailservice implements MessageService{
    @Override
    public String sendMessage() {
        return "Email:you have got new message...";
    }
}
