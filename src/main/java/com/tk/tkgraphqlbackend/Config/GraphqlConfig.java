package com.tk.tkgraphqlbackend.Config;


import graphql.kickstart.servlet.apollo.ApolloScalars;
import graphql.schema.GraphQLScalarType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GraphqlConfig {
    @Bean
    public GraphQLScalarType uploadScalarDefine(){
        return ApolloScalars.Upload;
    }
}
