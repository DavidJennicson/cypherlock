import { useState } from 'react'

import './App.css'
import TextField from '@mui/material/TextField';
import { Typography } from '@mui/material';
import {Button,Snackbar,Alert} from '@mui/material'
import ResponsiveDrawer from './components/ResponsiveDrawer';
import Signup from './components/Signup';
function App() {
 
  return (
    <>
  
   {/* <ResponsiveDrawer/>  */}
   <Signup/>
    </>
  )
}

export default App
