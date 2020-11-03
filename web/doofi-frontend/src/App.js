import React from "react";
import { BrowserRouter, Switch, Route } from "react-router-dom";
import Home from "./containers/Home";
import GlobalStyles from "./global";

function App() {
  return (
    <>
      <GlobalStyles />
      <BrowserRouter>
        <Switch>
          <Route path="/" exact component={Home} />
          <Route path="/client" component={{}} />
        </Switch>
      </BrowserRouter>
    </>
  );
}

export default App;
