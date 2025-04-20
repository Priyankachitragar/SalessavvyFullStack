
import React, { useState } from 'react';
import './assets/styles.css';
import { useNavigate } from 'react';

export default function Login() {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const [error, setError] = useState(null);

  const handleSignUp = async (e) => {
    e.preventDefault();
    setError(null); // Clear previous errors

    try {
      const response = await fetch('http://localhost:9090/api/auth/login', {
        method: 'POST', 
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify({ username, password}),
      });
      
      const data = await response.json();

      if (response.ok) {
        console.log('User Login successfully:', data);
        // Redirect to login page
        window.location.href = '/';
      } else {
        throw new Error(data.error || 'Login failed');
      }
    } catch (err) {
      
      setError(err.message);
    }
  };

  return (
    <div className="page-container">
      <div className="form-container">
        <h1 className="form-title">Login</h1>
        {error && <p className="error-message">{error}</p>}
        <form onSubmit={handleSignUp} className="form-content">
          <div className="form-group">
            <label htmlFor="username" className="form-label">Username</label>
            <input
              id="username"
              type="text"
              placeholder="Enter your username"
              value={username}
              onChange={(e) => setUsername(e.target.value)}
              required
              className="form-input"
            />
          </div>
         
          <div className="form-group">
            <label htmlFor="password" className="form-label">Password</label>
            <input
              id="password"
              type="password"
              placeholder="Enter your password"
              value={password}
              onChange={(e) => setPassword(e.target.value)}
              required
              className="form-input"
            />
          </div>
        
          <button type="submit" className="form-button">Sign In</button>
        </form>
        <p className="form-footer">
          New user?{' '}
          <a href="/register" className="form-link">Sign Up here</a>
        </p>
      </div>
    </div>
  );
}