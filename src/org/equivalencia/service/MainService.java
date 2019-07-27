package org.equivalencia.service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.equivalencia.model.Materia;
import org.equivalencia.view.Main;

import com.google.gson.Gson;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainService {


	public List<Materia> carregarMaterias() {
		
		OkHttpClient client = new OkHttpClient();

		Request request = new Request.Builder()
		  .url("http://"+Main.IP+":8080/disciplina/todos")
		  .get()
		  .build();

		try {
			Response response = client.newCall(request).execute();
			 Gson gson = new Gson();
			 Materia[] materiasV = gson.fromJson(response.body().string(), Materia[].class);
			 List<Materia> materias = Arrays.asList(materiasV);	
			return materias;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}
}
