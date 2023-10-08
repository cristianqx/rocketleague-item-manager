package com.rocketleague.itemmanager.gateway;

import com.rocketleague.itemmanager.exception.PathExistingException;

import java.io.IOException;

public interface ImageGateway {

    byte[] download(String url) throws IOException;

    void saveLocally(byte[] bytes, String name, String caminho) throws IOException, PathExistingException;
}
