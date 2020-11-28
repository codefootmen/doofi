import React from "react";
import { BrowserRouter, Switch, Route } from "react-router-dom";
import Home from "./containers/Home";
import Restaurant from "./containers/Restaurant";
import Bag from "./containers/Bag";

import GlobalStyles from "./global";

function App() {
  return (
    <>
      <GlobalStyles />
      <BrowserRouter>
        <Switch>
          <Route path="/" exact component={Home} />
          <Route path="/restaurant/:id" component={Restaurant} />
          <Route path="/bag" component={Bag} />
        </Switch>
      </BrowserRouter>
    </>
  );
}

export default App;
