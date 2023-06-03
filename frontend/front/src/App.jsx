import { useState } from 'react'

import './App.css'
import TextField from '@mui/material/TextField';
import { Typography } from '@mui/material';
import {Button,Snackbar,Alert} from '@mui/material'

function App() {
  const [email, setEmail] = useState('');
  const[password,setPassword]=useState('');
  const formData={username:email,password:password}
  const[message,setMessage]=useState('');
  const[severity,setSeverity]= useState('success');
  const handleEmailChange = (e) => {
    setEmail(e.target.value);
  };
  const handlePasswordChange = (e) => {
    setPassword(e.target.value)
  };
  const [open, setOpen] = useState(false);

  const handleClick = () => {
    setOpen(true);
  };

  const handleClose = () => {
    setOpen(false);
  };
  const handleSubmit = (e) => {
    e.preventDefault();

    fetch('http://localhost:8080/login/', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(formData),
    })
      .then((response) => response.json())
      .then((data) => {

        console.log('Success:', data);
        setMessage(data['message']);
        handleClick();
        if(data['status']===200)
        {
          setSeverity('success');
        }
        else
        {
          setSeverity('error');
        }
        // Handle the response data here
      })
      .catch((error) => {
        console.error('Error:', error);
        // Handle errors here
      });
  };
  return (
    <>
 <div className="container-fluid bx">
  <div className="container intbx">
    
    <br />
    <h4 style={{fontWeight:300}}>Cypherlock</h4>
    <br />
  <h2>Sign in</h2>
  <br />
  <TextField  style={{width:'20rem'}} value={email} onChange={handleEmailChange} id="outlined-basic" label="Email" variant="outlined" />
 <br />
  <TextField style={{width:'20rem',marginTop:'2em'}} onChange={handlePasswordChange} id="outlined-basic" label="Password" type='password' variant="outlined"/>
  <br />
  <br />
  <br />
  <Button size='large' style={{width:'20rem',fontSize:'1em',textTransform:'none'}} onClick={handleSubmit}  variant="contained">Login</Button>

  <br />
  <br />
 
<Snackbar open={open} autoHideDuration={6000} onClose={handleClose}  anchorOrigin={{ vertical: 'top', horizontal: 'center' }}>
  <Alert onClose={handleClose} severity={severity} sx={{ width: '100%' }}>
    {message}
  </Alert>
</Snackbar>


  </div>
 </div>

   
    </>
  )
}

export default App
