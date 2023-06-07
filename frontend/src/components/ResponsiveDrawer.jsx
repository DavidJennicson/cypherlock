import * as React from 'react';
import PropTypes from 'prop-types';
import AppBar from '@mui/material/AppBar';
import Box from '@mui/material/Box';
import CssBaseline from '@mui/material/CssBaseline';
import Divider from '@mui/material/Divider';
import Drawer from '@mui/material/Drawer';
import IconButton from '@mui/material/IconButton';
import { Button, Card,CardActions,CardContent, SpeedDialAction } from '@mui/material';
import List from '@mui/material/List';
import ListItem from '@mui/material/ListItem';
import ListItemButton from '@mui/material/ListItemButton';
import ListItemIcon from '@mui/material/ListItemIcon';
import ListItemText from '@mui/material/ListItemText';
import Modal from '@mui/material/Modal';
import SpeedDial from '@mui/material/SpeedDial';
import SpeedDialIcon from '@mui/material/SpeedDialIcon';
import TextField from '@mui/material/TextField';
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import Paper from '@mui/material/Paper';
import SearchIcon from '@mui/icons-material/Search';
import { useState } from 'react';
import Toolbar from '@mui/material/Toolbar';
import Typography from '@mui/material/Typography';
import upload from '../assets/upload.svg'
import doc from '../assets/doc.svg'
import image from '../assets/image.svg'
import movie from '../assets/movie.svg'
import folder from '../assets/folder.svg'
import Input from '@mui/material/Input';
const drawerWidth = 240;



function ResponsiveDrawer(props) {
  const { window } = props;
  const [mobileOpen, setMobileOpen] = React.useState(false);
  const now = 60;
  const handleDrawerToggle = () => {
    setMobileOpen(!mobileOpen);
  };
  const [selectedFile, setSelectedFile] = useState(null);
  const handleFilechange = (event) => {
    const file=event.target.files[0];
    setSelectedFile(file);
  }
  const handlefileButtonClick = () => {
    // Do something with the selected file
    if (selectedFile) {
      console.log(selectedFile);
      const formData = new FormData();
    formData.append('file', selectedFile);
    formData.append('password','1234')

    fetch('http://localhost:8080/files/encrypt', {
      method: 'POST',
      body: formData,
    })
      .then((response) => response.json())
      .then((data) => {
        console.log('Upload successful!', data);
        console.log(formData[1]);
      })
      .catch((error) => {
        console.error('Error:', error);
      });
      // Perform your desired actions with the selected file
    } else {
      console.log('No file selected');
    }
  };
  const style = {
    position: 'absolute',
    top: '50%',
    left: '50%',
    transform: 'translate(-50%, -50%)',
    width: 400,
    bgcolor: 'background.paper',
    border: '0 solid #000 ',
    borderRadius:'20px',
    boxShadow: 24,
    p: 4,
  };
  
  const [open, setOpen] = React.useState(false);
  const handleOpen = () => setOpen(true);
  const handleClose = () => setOpen(false);
  const drawer = (
    <div>
      <Toolbar />
      <Divider />
  
      <List>
        <ListItem disablePadding>
<ListItemButton style={{backgroundColor:'#c0d0fc',color:'#111c38',height:'3em',borderRadius:'20px',textAlign:'center'}} onClick={handleOpen}>
  Upload <img src={upload} style={{width:'25px'}} />
</ListItemButton>
        </ListItem>
      </List>
      <Divider />
      
    </div>
  );

  const container = window !== undefined ? () => window().document.body : undefined;

  return (
    <Box sx={{ display: 'flex' }}>
      <CssBaseline />
      <AppBar
        position="fixed"
        style={{backgroundColor:'white',height:'4em',boxShadow:'0 2px 4px rgba(0, 0, 0, 0.1)'}}
        sx={{
          width: { sm: `calc(100% - ${drawerWidth}px)` },
          
          ml: { sm: `${drawerWidth}px` },
        }}
      >
        <Toolbar>
          <IconButton
            color="inherit"
            aria-label="open drawer"
            edge="start"
            onClick={handleDrawerToggle}
            sx={{ mr: 2, display: { sm: 'none' } }}
          >
          
          </IconButton>
       {/* RFWRV */}
       
        </Toolbar>
      </AppBar>
      <Box
        component="nav"
        sx={{ width: { sm: drawerWidth }, flexShrink: { sm: 0 } }}
        aria-label="mailbox folders"
      >
        {/* The implementation can be swapped with js to avoid SEO duplication of links. */}
        <Drawer
          container={container}
          variant="temporary"
          open={mobileOpen}
          onClose={handleDrawerToggle}
          ModalProps={{
            keepMounted: true, // Better open performance on mobile.
          }}
          sx={{
            display: { xs: 'block', sm: 'none' },
            '& .MuiDrawer-paper': { boxSizing: 'border-box', width: drawerWidth },
          }}
        >
          {drawer}
        </Drawer>
        <Drawer
          variant="permanent"
          sx={{
            display: { xs: 'none', sm: 'block' },
            '& .MuiDrawer-paper': { boxSizing: 'border-box', width: drawerWidth },
          }}
          open
        >
          {drawer}
        </Drawer>
      </Box>
      <Box
      
        component="main"
        sx={{ flexGrow: 1, p: 3, width: { sm: `calc(100% - ${drawerWidth}px)` } }}
      >
        <Toolbar />
  <div className="container-fluid ">
  <div className="row">
  <div className="col-sm-3 mb-3 mb-sm-0">
    <div className="card" style={{backgroundColor:'#f7c8c8',borderRadius:'15px'}}>
    <div className="card-body row" style={{ display: 'flex', alignItems: 'center' }}>
 <img src={image} alt=""  style={{width:'6em'}}/>
  <h5 className="card-title col-6 row">Image</h5>

</div>
<div className="container ">
<div style={{width:'90%',height:'3px',backgroundColor:'white',marginLeft:'7px',borderRadius:'2px'}}>
  <div style={{width:'70%',height:'3px',backgroundColor:'#e36868',borderRadius:'2px'}}></div>
 </div>
</div>
<br />
    </div>
  </div>
  <div className="col-sm-3 mb-3 mb-sm-0">
    <div className="card" style={{backgroundColor:'#dfe3f6',borderRadius:'15px'}}>
    <div className="card-body row" style={{ display: 'flex', alignItems: 'center' }}>
    <img src={doc} alt="" style={{width:'6em'}}/>
 
  <h5 className="card-title col-6 row">Document</h5>

</div>
<div className="container ">
<div style={{width:'90%',height:'3px',backgroundColor:'white',marginLeft:'7px',borderRadius:'2px'}}>
  <div style={{width:'70%',height:'3px',backgroundColor:'#7ea2f9',borderRadius:'2px'}}></div>
 </div>
</div>
<br />
    </div>
  </div>
  <div className="col-sm-3 mb-3 mb-sm-0">
    <div className="card" style={{backgroundColor:'#e5dff5',borderRadius:'15px'}}>
    <div className="card-body row" style={{ display: 'flex', alignItems: 'center' }}>
    
<img src={movie}  alt="" style={{width:'6em'}}/>
  <h5 className="card-title col-6 row">Videos</h5>

</div>
<div className="container ">
<div style={{width:'90%',height:'3px',backgroundColor:'white',marginLeft:'7px',borderRadius:'2px'}}>
  <div style={{width:'70%',height:'3px',backgroundColor:'#9779e0',borderRadius:'2px'}}></div>
 </div>
</div>
<br />
    </div>
  </div>
  <div className="col-sm-3 mb-3 mb-sm-0">
    <div className="card" style={{backgroundColor:'#f6f7e1',borderRadius:'15px'}}>
    <div className="card-body row" style={{ display: 'flex', alignItems: 'center' }}>
   
<img src={folder}  alt="" style={{width:'6em'}}/>
 
  <h5 className="card-title col-6 row">All files</h5>

</div>
<div className="container ">
<div style={{width:'90%',height:'3px',backgroundColor:'white',marginLeft:'7px',borderRadius:'2px'}}>
  <div style={{width:'70%',height:'3px',backgroundColor:'#aba624',borderRadius:'2px'}}></div>
 </div>
</div>
<br />
    </div>
  </div>

 

</div>
  </div>
  <br />

  <TableContainer  component={Paper}>
      <Table  aria-label="simple table">
        <TableHead>
          <TableRow >  
          
       
  </TableRow>
         
        </TableHead>
        <TableBody>
         <TableRow><TableCell></TableCell></TableRow>
        </TableBody>
      </Table>
    </TableContainer>
    <br />
    <div>
   
      <Modal
        open={open}
        onClose={handleClose}
        aria-labelledby="modal-modal-title"
        aria-describedby="modal-modal-description"
      >
        <Box sx={style}>
        <h4 className='text-center' style={{fontWeight:'400'}}>Upload file</h4>
        <Input
        type="file"
        onChange={ handleFilechange}
        inputProps={{ accept: 'image/*' }} // Specify accepted file types if needed
      />
      
      <Button variant="contained" style={{marginTop:'1em'}} onClick={handlefileButtonClick}>
        Upload
      </Button>
        </Box>
      </Modal>
    </div>

      </Box>
    </Box>
  );
}

ResponsiveDrawer.propTypes = {
  /**
   * Injected by the documentation to work in an iframe.
   * You won't need it on your project.
   */
  window: PropTypes.func,
};

export default ResponsiveDrawer;