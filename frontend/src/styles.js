import styled, { keyframes, css } from "styled-components";

export const HeaderStyle = styled.div`
  display: flex;
  overflow: hidden;
  height: 80px;
  border-bottom: 1px solid #cccccc;
  justify-content: space-between;

  div#logo {
    display: flex;
    img {
      padding: 10px;
      width: 120px;
      height: 80px;
      margin-left: 200px;
    }
  }
  div#bag-icon {
    margin: 0 250px 0 0;

    svg {
      margin-bottom: -6px;
    }
    a {
      display: block;
      margin-top: 19px;
      color: black;
    }
  }
`;

//background: url(${plateThree}) right no-repeat;

const translate = keyframes`
  from {
    transform: translateY(-100px);
  }

  to {
    transform: translateY(0px);
  }
`;

export const Content = styled.div`
  max-width: 1250px;
  margin: 20px auto;
  h1 {
    margin: 40px 0;
  }
  h2 {
    margin: 50px 0 5px 0;
  }

  h3 {
    margin: 5px 0 50px 0;
    color: #888888;
  }

  .cards {
    display: flex;
    justify-content: space-between;
    flex-wrap: wrap;
  }

  .cards > * {
  }
`;

export const Card = styled.div`
  width: 405px;
  background: #fff;
  height: 130px;
  display: flex;
  flex-direction: column;
  transisiton: 0.2s;
  border-radius: 4px;
  cursor: pointer;
  margin: 10px 0;

  strong {
    font-size: 1.5em;
    margin: 30px 0px 30px 30px;
    color: #000;
  }

  span {
    margin: 0px 0px auto 30px;
    color: #a6aec5;
  }

  &:hover {
    transform: scale(1.04);
  }
`;

export const Button = styled.div`
  display: flex;
  justify-content: flex-end;
  button {
    margin-right: 30px;
    height: 30px;
    width: 80px;
    color: white;
    border: 0px solid red;
    background-color: rgb(234, 29, 44);
    border-radius: 4px;
  }
  button:hover {
    background-color: #990000;
  }
`;

export const Table = styled.table`
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
    
    td, th {
      border: 1px solid #dddddd;
      text-align: left;
      padding: 8px;
    }
    
    tr:nth-child(even) {
      background-color: #dddddd;
    }
  }
`;
