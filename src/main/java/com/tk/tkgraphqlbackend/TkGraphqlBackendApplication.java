package com.tk.tkgraphqlbackend;

import graphql.scalars.ExtendedScalars;
import graphql.schema.GraphQLScalarType;
import graphql.schema.idl.RuntimeWiring;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableAutoConfiguration
public class TkGraphqlBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(TkGraphqlBackendApplication.class, args);
		RuntimeWiring.newRuntimeWiring().scalar(ExtendedScalars.GraphQLBigInteger);
		RuntimeWiring.newRuntimeWiring().scalar(ExtendedScalars.GraphQLBigDecimal);
		RuntimeWiring.newRuntimeWiring().scalar(ExtendedScalars.Object);
		RuntimeWiring.newRuntimeWiring().scalar(ExtendedScalars.GraphQLLong);

	}

	@Bean
	public GraphQLScalarType graphQLScalarBigDecimal(){
		return ExtendedScalars.GraphQLBigDecimal;
	}

	@Bean
	public GraphQLScalarType graphQLScalarBigInteger(){
		return ExtendedScalars.GraphQLBigInteger;
	}

	@Bean
	public GraphQLScalarType graphQLObject(){
		return ExtendedScalars.Object;
	}

	@Bean
	public GraphQLScalarType graphQLLong(){
		return ExtendedScalars.GraphQLLong;
	}
}
