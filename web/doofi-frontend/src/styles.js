import styled, { keyframes, css } from "styled-components";

export const Header = styled.div`
  display: flex;
  overflow: hidden;
  height: 100vh;

  nav {
    position: absolute;
    width: 100%;
    display: flex;
    align-items: center;
    justify-content: flex-end;
    padding: 0 65px;
    margin: 52px 10px 90px 0px;

    a {
      text-decoration: none;
      color: #ea1d2c;
      font-weight: bold;
      margin-right: 40px;
    }

    button {
      width: 140px;
      height: 50px;
      background: #fff;

      border: 1px solid;
      border-radius: 3px;
      border-color: rgba(234, 19, 44 0.1);

      color: #ea1d2c;
      font-weight: bold;
    }

    button:hover {
      background: #ea1d2c;
      color: #fff;
    }
  }

  div#logo {
    width: 100%;
    position: absolute;
    margin-top: 40px;
    display: flex;

    img {
      margin: auto auto;
      width: 200px;
      height: 120px;
    }
  }

  img#plate-one {
    margin-left: 13px;
    width: 660px;
    height: 290px;
  }

  div#plate-two {
    margin-top: 30px;
    margin-left: auto;
    width: 450px;
    height: 550px;

    background-size: cover;
  }

  div#plate-three {
    margin-right: auto;
    width: 410px;
    height: 500px;

    background-size: cover;
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

export const Slogan = styled.div`
  width: 100%;
  margin-top: 50vh;
  position: absolute;
  color: #3e3e3e;

  animation: ${translate} 1.8s;

  div#slogan {
    margin: 0 auto;
    max-width: 600px;
    display: grid;
    grid-template-rows: 1fr 1fr 2fr;
    height: 400px;
    justify-items: center;

    strong {
      text-align: center;
      letter-spacing: -1px;
      line-height: 4.9375rem;
      font-size: 4rem;
    }

    span {
      letter-spacing: -1px;
      font-weight: 300;
      line-height: 2.3125rem;
      font-size: 1.875rem;
    }

    button {
      color: #fff;
      background: #ea1d2c;
      width: 100%;
      max-width: 360px;
      height: 60px;
      border: none;
      border-radius: 4px;
      font-weight: 400;
      line-height: 2.3125rem;
      font-size: 1.575rem;
      padding: 0px 40px;

      display: flex;
      align-items: center;
      justify-content: space-between;

      svg {
        margin-right: 15px;
      }
    }
  }
`;

export const Content = styled.div`
  max-width: 1250px;
  margin: 20px auto;

  .cards {
    display: flex;
    justify-content: space-between;
    flex-wrap: wrap;
  }
`;

export const Jumbotron = styled.div`
  display: flex;
  height: 326px;
  width: 100%;
  background: #ea1d2c;
  color: #fff;
  border-radius: 14px;
  margin-bottom: 50px;
  padding: 40px 0 0 40px;

  div {
    display: flex;
    flex-direction: column;
    align-items: space-between;
    color: #fff;
    width: 100%;
    height: 100%;

    strong {
      font-size: 3.125rem;
      line-height: 3.875rem;
      margin-top: 25px;
      margin-bottom: 15px;
    }

    span {
      font-size: 1.4375rem;
      width: 500px;
      margin-bottom: 30px;
    }

    button {
      width: 320px;
      height: 60px;
      color: #ea1d2c;
      background: #fff;
      font-weight: bold;
      font-size: 15px;

      border: 1px solid;
      border-radius: 3px;
      border-color: rgba(234, 19, 44 0.1);
    }

    button:hover {
      color: #fff;
      background: #ea1d2c;
    }
  }
  img {
    margin-left: auto;
  }
`;

export const Card = styled.div`
  width: 405px;
  background: #fff;
  height: 350px;
  border-radius: 14px;
  display: flex;
  flex-direction: column;
  transisiton: 0.2s;
  box-shadow: 0 0 20px rgba(0, 0, 0, 0.2);

  img {
    border-top-left-radius: 14px;
    border-top-right-radius: 14px;
  }

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
