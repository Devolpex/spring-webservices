import { ApolloClient, InMemoryCache } from "@apollo/client";
import { env } from "./env";

const qraphqlClient = new ApolloClient({
  uri: env.REACT_APP_GRAPHQL_URI,
  cache: new InMemoryCache(),
});

export default qraphqlClient;
