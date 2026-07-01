import './Home.css';
import { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';
import { getAboutInfo } from '../services/api';

export default function Home() {
  // Show explicit name and designation per user's request
  const [typed, setTyped] = useState('');

  // Use the specific name and designation requested
  const name = 'NITYARANJAN JENA';
  const designation = 'Spring Boot Backend Developer';

  useEffect(() => {
    let i = 0;
    setTyped('');
    const timer = setInterval(() => {
      i += 1;
      setTyped(designation.slice(0, i));
      if (i >= designation.length) clearInterval(timer);
    }, 50);
    return () => clearInterval(timer);
  }, [designation]);

  return (
    <section id="home" className="home-hero-unique">
      <div className="blobs">
        <svg className="blob blob1" viewBox="0 0 200 200" xmlns="http://www.w3.org/2000/svg">
          <path fill="url(#grad1)" d="M43.6,-60.1C57.6,-49.8,70.7,-36.4,76.3,-20.5C82,-4.6,80.1,13.9,71,28.6C61.9,43.4,45.7,54.5,28,60.6C10.2,66.7,-8.9,67.7,-25.1,61.8C-41.4,55.9,-54.7,43.1,-61.6,27.3C-68.5,11.4,-69,-8.6,-61.4,-26.6C-53.7,-44.6,-37.9,-60.5,-19.6,-68.7C-1.3,-76.9,19.7,-77.3,43.6,-60.1Z" transform="translate(100 100)"/>
          <defs>
            <linearGradient id="grad1" x1="0%" y1="0%" x2="100%" y2="100%">
              <stop offset="0%" stopColor="#7c3aed" />
              <stop offset="100%" stopColor="#06b6d4" />
            </linearGradient>
          </defs>
        </svg>
        <svg className="blob blob2" viewBox="0 0 200 200" xmlns="http://www.w3.org/2000/svg">
          <path fill="url(#grad2)" d="M39.6,-61.7C51.6,-52.7,60.1,-41.1,66.9,-27.5C73.8,-13.9,78.9,1.8,76.1,18.3C73.2,34.8,62.3,51.9,47.2,60.6C32.1,69.3,12.8,69.6,-5.2,74.1C-23.1,78.6,-40.3,87.3,-52.3,80C-64.3,72.7,-71.1,49.5,-74.2,27.9C-77.3,6.3,-76.6,-13.7,-67.8,-29.2C-59,-44.7,-42.2,-55.6,-24.3,-62.6C-6.3,-69.6,12.8,-72.6,39.6,-61.7Z" transform="translate(100 100)"/>
          <defs>
            <linearGradient id="grad2" x1="0%" y1="0%" x2="100%" y2="100%">
              <stop offset="0%" stopColor="#ef4444" />
              <stop offset="100%" stopColor="#f59e0b" />
            </linearGradient>
          </defs>
        </svg>
      </div>

      <div className="hero-card">
        <h1 className="hero-title">{name}</h1>
        <p className="hero-typewriter">{typed}<span className="cursor">|</span></p>

        <div className="hero-ctas">
          <Link className="btn primary" to="/about">About</Link>
          <Link className="btn ghost" to="/contact">Contact</Link>
        </div>
      </div>
    </section>
  );
}
