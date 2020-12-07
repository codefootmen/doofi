import React from "react";
import { BrowserRouter, Switch, Route } from "react-router-dom";
import Home from "./containers/Home";
import Restaurant from "./containers/Restaurant";
import Bag from "./containers/Bag";
import Orders from "./containers/Orders";

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
          <Route path="/orders" component={Orders} />
        </Switch>
      </BrowserRouter>
    </>
  );
}

export default App;
