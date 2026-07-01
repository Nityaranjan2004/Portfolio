import '../styles/Header.css';
import { NavLink } from 'react-router-dom';

export default function Header() {
  return (
    <header className="header">
      <nav className="navbar">
        <div className="container nav-container">
          <div className="logo">
            <h1>Portfolio</h1>
          </div>
          <ul className="nav-links">
            <li><NavLink to="/" className={({ isActive }) => isActive ? 'nav-link active' : 'nav-link'}>Home</NavLink></li>
            <li><NavLink to="/about" className={({ isActive }) => isActive ? 'nav-link active' : 'nav-link'}>About</NavLink></li>
            <li><NavLink to="/skills" className={({ isActive }) => isActive ? 'nav-link active' : 'nav-link'}>Skills</NavLink></li>
            <li><NavLink to="/projects" className={({ isActive }) => isActive ? 'nav-link active' : 'nav-link'}>Projects</NavLink></li>
            <li><NavLink to="/experience" className={({ isActive }) => isActive ? 'nav-link active' : 'nav-link'}>Experience</NavLink></li>
            <li><NavLink to="/education" className={({ isActive }) => isActive ? 'nav-link active' : 'nav-link'}>Education</NavLink></li>
            <li><NavLink to="/certificates" className={({ isActive }) => isActive ? 'nav-link active' : 'nav-link'}>Certificates</NavLink></li>
            <li><NavLink to="/contact" className={({ isActive }) => isActive ? 'nav-link active' : 'nav-link'}>Contact</NavLink></li>
          </ul>
        </div>
      </nav>
    </header>
  );
}
