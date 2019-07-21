package br.edu.ifpb.bicos.service;

public interface SecurityService {
    String findLoggedInUsername();

    void autoLogin(String username, String password);
}