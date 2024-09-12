// reducers/index.js

import adminReducer from '@/features/Admin/AdminSlice';

import authReducer from '@/features/auth/AuthSlice';
import { combineReducers } from 'redux';

const rootReducer = combineReducers({
  auth: authReducer,

  admin:adminReducer
  // ...other reducers
  
});

export default rootReducer;
