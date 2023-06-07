import { useState } from 'react'

import './App.css'
import TextField from '@mui/material/TextField';
import { Typography } from '@mui/material';
import {Button,Snackbar,Alert} from '@mui/material'
import ResponsiveDrawer from './components/ResponsiveDrawer';
import Signup from './components/Signup';
import {Routes,Route,useNavigate} from "react-router-dom";
function App() {

  return (
    <>
    <Routes>
      <Route path="/" element={<Signup />} />
      <Route path="/home" element={<ResponsiveDrawer />} />
    </Routes>

   {/* <ResponsiveDrawer/>  */}
   {/* <Signup/> */}
    </>
  )
}

export default App
