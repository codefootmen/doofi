export const Types = {
  ADD_PRODUCT: "ADD_PRODUCT",
  REMOVE_PRODUCT: "REMOVE_PRODUCT",
};

const initialState = {
  user: {
    name: "joe",
    email: "joe@notreal.com",
    token: "oaheoheaoheohaeoheo",
  },
  products: [],
};

export const addItem = (payload) => {
  return { type: "ADD_PRODUCT", payload };
};

export default function reducer(state = initialState, action) {
  if (action.type === "ADD_PRODUCT") {
    const result = { ...state, products: [...state.products, action.payload] };
    console.log(result);
    return result;
  }
  if (action.type === "REMOVE_PRODUCT") {
    return { ...state, products: [...state.products, action.payload] };
  }
  return state;
}
