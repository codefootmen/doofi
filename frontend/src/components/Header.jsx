import React from "react";
import { IconContext } from "react-icons";
import { HeaderStyle } from "../styles";
import { Link } from "react-router-dom";
import { BiShoppingBag } from "react-icons/bi";
import logo from "../assets/doofi.png";

export default function Header() {
  return (
    <HeaderStyle>
      <div id="logo">
        <Link to="/" style={{ textDecoration: "none" }}>
          <img id="logo" src={logo} alt="Doofi" />
        </Link>
      </div>
      <div id="bag-icon">
        <Link to="/bag" style={{ textDecoration: "none" }}>
          <IconContext.Provider value={{ size: "2em" }}>
            <BiShoppingBag />
          </IconContext.Provider>
          Sacola
        </Link>
      </div>
    </HeaderStyle>
  );
}
