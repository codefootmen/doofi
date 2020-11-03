import { createGlobalStyle } from "styled-components";

export default createGlobalStyle`
  * {
    margin: 0;
    padding:0;
    outline: 0;
    box-sizing: border-box;
  }

  body {
    min-height: 100%;
    background: #F3F3F4;
  }

  html, body, input {
    font-family: sans-serif;
  }

  button {
    cursor: pointer;
  }
`;
