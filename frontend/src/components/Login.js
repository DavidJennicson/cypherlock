
import {React, useState,useRef} from 'react';
import { MDBBtn, MDBContainer, MDBRow, MDBCol, MDBCard, MDBCardBody, MDBInput, MDBIcon, MDBCheckbox } from 'mdb-react-ui-kit';
import lock from './lock.png'

import {motion} from 'framer-motion';
import './Login.css';
function Login() {
  const [animateY, setAnimateY] = useState(-25);
    const [email, setEmail] = useState('');

  const [password, setPassword] = useState('');
  const[show,setShow]=useState(false);
  const[showres,setShowres]=useState(false);
  const [loginmessage, setloginmessage] = useState('')
  const[color,setColor]=useState('');
    const handleEmailChange = (event) => {
    setEmail(event.target.value);
    console.log(email);
  };
  const formData ={
  
    username: email,password:password
  };
  const handleSubmit = (event) => {
    event.preventDefault();

    fetch('http://localhost:8080/login/', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(formData)
    })
      .then(response => response.json())
      .then(data => {
        // Handle the response data
        console.log(data);
        setAnimateY(-25);
        const timeoutId = setTimeout(() => {
          // Code to be executed after the timeout
          setAnimateY(0);
        }, 100);
        
          setloginmessage(data['message']);
        if (data['status']===200)
        {
          
          setColor('green')
        }
        else
        {
          setColor('#b30000')
        }
      
      })
      .catch(error => {
        // Handle errors
        console.error(error);
      });
  };

  const handleCheckboxChange = (e) => {
    setShow(e.target.checked);
  };
  const handlePasswordChange = (event) => {
    setPassword(event.target.value);
  };
  const getInputType = () => {
    return setShow ? 'text' : 'password';
  };

 
  const handleEvent = () => {
    setShowElement(true);
  };

  return (
    <>
<motion.div  initial={{y:-25}} animate={{ y: animateY }}><p className='text-center' style={{backgroundColor:color,color:'white'}}>{loginmessage}</p></motion.div>
    <MDBContainer fluid >

      <MDBRow className="d-flex justify-content-center align-items-center height"  >
      
        <MDBCol col="6">
          <MDBCard className="my-5 mx-auto" style={{ borderRadius: '1rem', maxWidth: '500px'  }}>
            <MDBCardBody className="p-5 w-100 d-flex flex-column">
              <h4 className="logo text-center">Cypherlock <img src={lock}  alt=''/> </h4>
              <br />
              <h1 className="mb-2 text-center regular">Sign in</h1>
              <p className="text-white-50 mb-3">Please enter your login and password!</p>

         
    <br />
    
<br />
              <MDBInput wrapperClass="mb-4 w-100 regular" label="Email address" id="formControlLg" value={email} onChange={handleEmailChange} type="email" size="lg" />
              <MDBInput wrapperClass="mb-4 w-100 regular" label="Password" id="formControlLg" type='password' value={password} onChange={handlePasswordChange} size="lg" />

           
              <MDBBtn
                wrapperClass="bold"
                onClick={handleSubmit}
                style={{ textTransform: 'none' ,fontSize:'1em',fontWeight:400}}
              >
                Login
              </MDBBtn>

              <hr className="my-4" />
            </MDBCardBody>
          </MDBCard>
        </MDBCol>
      </MDBRow>
    </MDBContainer>
    </>
  )
}

export default Login