import { createStore, applyMiddleware } from "redux";
import reducer from "./ducks/bag";

import createSagaMiddleware from "redux-saga";

// const middleware = createSagaMiddleware();
// const store = createStore(reducer, applyMiddleware(middleware));
// middleware.run(generator);

export default createStore(reducer);
