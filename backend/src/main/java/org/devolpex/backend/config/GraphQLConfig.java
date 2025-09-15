// package org.devolpex.backend.config;

// import java.io.File;
// import java.io.IOException;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;

// import graphql.schema.GraphQLSchema;
// import graphql.schema.idl.RuntimeWiring;
// import graphql.schema.idl.SchemaGenerator;
// import graphql.schema.idl.SchemaParser;
// import graphql.schema.idl.TypeDefinitionRegistry;

// @Configuration
// public class GraphQLConfig {
//     @Bean
//     public GraphQLSchema graphQLSchema(RuntimeWiring runtimeWiring) throws IOException {
//         SchemaParser schemaParser = new SchemaParser();
//         SchemaGenerator schemaGenerator = new SchemaGenerator();

//         // Load all schema files
//         File[] schemaFiles = new File("src/main/resources/graphql/").listFiles();
//         TypeDefinitionRegistry typeRegistry = new TypeDefinitionRegistry();

//         for (File schemaFile : schemaFiles) {
//             typeRegistry.merge(schemaParser.parse(schemaFile));
//         }

//         return schemaGenerator.makeExecutableSchema(typeRegistry, runtimeWiring);
//     }

// }
