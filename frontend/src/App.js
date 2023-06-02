import {React, useState} from 'react';
import { MDBBtn, MDBContainer, MDBRow, MDBCol, MDBCard, MDBCardBody, MDBInput, MDBIcon, MDBCheckbox } from 'mdb-react-ui-kit';

function App() {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');

  const handleEmailChange = (event) => {
    setEmail(event.target.value);
    console.log(email);
  };

  const handlePasswordChange = (event) => {
    setPassword(event.target.value);
  };

  return (
    <MDBContainer fluid>
      <div className="u"></div>
      <MDBRow className="d-flex justify-content-center align-items-center h-100" style={{backgroundColor:'blue'}}>
        <MDBCol col="6">
          <MDBCard className="my-5 mx-auto" style={{ borderRadius: '1rem', maxWidth: '500px'}}>
            <MDBCardBody className="p-5 w-100 d-flex flex-column">
              <h4 className="logo text-center">AnneAI Cypher</h4>
              <br />
              <h1 className="mb-2 text-center regular">Sign in</h1>
              <p className="text-white-50 mb-3">Please enter your login and password!</p>

              <MDBInput wrapperClass="mb-4 w-100 regular" label="Email address" id="formControlLg" value={email} onChange={handleEmailChange} type="email" size="lg" />
              <MDBInput wrapperClass="mb-4 w-100 regular" label="Password" id="formControlLg" type="password" value={password} onChange={handlePasswordChange} size="lg" />

              <MDBCheckbox name="flexCheck" id="flexCheckDefault" className="mb-4 regular" label="Remember password" />

              <MDBBtn
                wrapperClass="bold"
                style={{
                  background: 'linear-gradient(to right, #007aff, #34aadc)',
                  fontFamily: 'Inter, sans-serif',
                }}
              >
                Login
              </MDBBtn>

              <hr className="my-4" />
            </MDBCardBody>
          </MDBCard>
        </MDBCol>
      </MDBRow>
    </MDBContainer>
  );
}

export default App;
