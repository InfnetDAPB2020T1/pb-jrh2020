package com.example.gestorfinanceiro.api;

import com.example.gestorfinanceiro.entidades.Cotacao;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CotacaoService {


    @GET("latest?base=USD")
    Call<Cotacao> converterMoeda();
}
