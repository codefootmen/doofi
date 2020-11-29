export const Types = {
  LOGIN: "auth/LOGIN",
  LOGOUT: "auth/LOGOUT",
};

const initialState = {
  name: "joe",
  email: "joe@notreal.com",
  token: "oaheoheaoheohaeoheo",
};

export default function reducer(state = initialState, action) {
  switch (
    action.type
    // case Types.LOGIN:
    //   return {...};
    // case Types.LOGOUT:
    //   return {...};
    // default:
    //   return state;
  ) {
  }
}
