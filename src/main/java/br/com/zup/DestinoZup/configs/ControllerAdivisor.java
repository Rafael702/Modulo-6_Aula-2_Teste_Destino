package br.com.zup.DestinoZup.configs;

import br.com.zup.DestinoZup.destino.exceptions.RegiaoNaoEncontradaException;
import org.modelmapper.internal.util.Maps;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

@RestControllerAdvice
public class ControllerAdivisor {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public HashMap<String,HashMap<String, String>> manipulandoValidacao(MethodArgumentNotValidException exception){
        HashMap<String, HashMap<String, String>> resposta = new HashMap<>();

        for (FieldError error : exception.getFieldErrors()){
            HashMap<String, String> mensagem = construirResposta(error.getDefaultMessage());
            resposta.put(error.getField(), mensagem);
        }
        return resposta;
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public HashMap<String, String> manipularRuntimeException(RuntimeException exception){
        return construirResposta(exception.getMessage());
    }

    @ExceptionHandler(RegiaoNaoEncontradaException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public HashMap<String, String> manipularRuntimeException(RegiaoNaoEncontradaException exception){
        return construirResposta("Região não existe");
    }

    private HashMap<String, String> construirResposta(String mensagem){
        HashMap<String, String> resposta = new HashMap<>();
        resposta.put("mensagem", mensagem);
        return resposta;
    }

}
