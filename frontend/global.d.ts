// global.d.ts
interface Window {
    env: {
      REACT_APP_API_ENDPOINT: string;
      REACT_APP_GRAPHQL_URI: string;
    };
  }