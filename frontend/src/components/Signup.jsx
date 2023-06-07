import {React,useState} from 'react'
import {Button,TextField,Snackbar,Alert} from '@mui/material'
import { FormControl, InputLabel, OutlinedInput, InputAdornment, IconButton } from '@mui/material';
import Visibility from '@mui/icons-material/Visibility';
import VisibilityOff from '@mui/icons-material/VisibilityOff';
import { useNavigate } from 'react-router-dom';
function Signup() {
  const navigate=useNavigate();
    const [email, setEmail] = useState('');
const[password,setPassword]=useState('');
const formData={username:email,password:password}
const[message,setMessage]=useState('');
const[severity,setSeverity]= useState('success');
const handleEmailChange = (e) => {
  setEmail(e.target.value);
};
const [showPassword, setShowPassword] =useState(false);

const handleClickShowPassword = () => setShowPassword((show) => !show);

const handleMouseDownPassword = (event) => {
  event.preventDefault();
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
        navigate('/home');
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
   <br />
   <TextField  style={{width:'20rem'}} value={email} onChange={handleEmailChange} id="outlined-basic" label="Email" variant="outlined" />
  <br />
   {/* <TextField size='small' style={{width:'20rem',marginTop:'2em'}} onChange={handlePasswordChange} id="outlined-basic" label="Password" type='password' variant="outlined"/> */}
   
   <FormControl sx={{ m: 1, width: '20rem' }}  variant="outlined">
          <InputLabel htmlFor="outlined-adornment-password">Password</InputLabel>
          <OutlinedInput
            id="outlined-adornment-password"
            type={showPassword ? 'text' : 'password'}
            value={password}
            onChange={handlePasswordChange}
            endAdornment={
              <InputAdornment position="end">
                <IconButton
                  aria-label="toggle password visibility"
                  onClick={handleClickShowPassword}
                  onMouseDown={handleMouseDownPassword}
                  edge="end"
                >
                  {showPassword ? <VisibilityOff /> : <Visibility />}
                </IconButton>
              </InputAdornment>
            }
            label="Password"
          />
        </FormControl>

   <br />
   
  <br />
   <Button size='large' style={{width:'20rem',fontSize:'1em',textTransform:'none',color:'white',backgroundColor:'#1964ff'}} onClick={handleSubmit}  variant="contained">Login</Button>
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

export default Signup