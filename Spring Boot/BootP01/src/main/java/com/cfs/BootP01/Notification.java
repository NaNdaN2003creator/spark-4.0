package com.cfs.BootP01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Notification {

    public MessageService getMessageService() {
        return messageService;
    }

    public void setMessageService(MessageService messageService) {
        this.messageService = messageService;
    }
    @Autowired
    private MessageService messageService;

    public  Notification()
    {

    }

    public Notification(MessageService messageService)
    {
        this.messageService= messageService;
    }

    public void notifyUser()
    {
        System.out.println(messageService.sendMessage());
    }
}
