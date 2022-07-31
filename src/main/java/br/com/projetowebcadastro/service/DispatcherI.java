package br.com.projetowebcadastro.service;

import br.com.projetowebcadastro.bo.IBookBusinessObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface DispatcherI {
    void dispatchForward(HttpServletRequest req, HttpServletResponse resp, IBookBusinessObject bookBusinessObject)
            throws ServletException, IOException;
}
