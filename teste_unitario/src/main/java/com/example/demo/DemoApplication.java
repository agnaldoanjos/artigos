package com.example.demo;

import com.example.demo.logic.Calculadora;

public class DemoApplication {


	private Calculadora calculadora;

	public DemoApplication(Calculadora calculadora) {
		this.calculadora = calculadora;
	}

	public int somar(int a, int b){
		return this.calculadora.somar(a, b);
	}

	public static void main(String[] args) {

		DemoApplication application = new DemoApplication(new Calculadora());

		System.out.println(application.somar(1, 3));

	}

}
