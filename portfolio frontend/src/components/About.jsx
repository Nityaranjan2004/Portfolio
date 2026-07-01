import { useState, useEffect } from 'react';
import { getAboutInfo } from '../services/api';
import '../styles/About.css';
import profilePic from '../assets/nitya.jpeg';

// Default profile image imported from src/assets
const DEFAULT_PROFILE_IMAGE = profilePic;

export default function About() {
  const [about, setAbout] = useState(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    const fetchAbout = async () => {
      try {
        const response = await getAboutInfo();
        // Extract data from nested structure
        const aboutData = response?.data || response?.about || response;
        setAbout(aboutData);
      } catch (err) {
        setError(err.message);
      } finally {
        setLoading(false);
      }
    };

    fetchAbout();
  }, []);

  if (loading) return <div className="section-loading">Loading about info...</div>;
  if (error) return <div className="section-error">Error: {error}</div>;
  if (!about) return <div className="section-empty">No about information available</div>;

  const imageUrl = about.image || DEFAULT_PROFILE_IMAGE;

  return (
    <section id="about" className="about-section">
      <div className="container">
        <h2 className="section-title">About Me</h2>
        <div className="about-content">
          <div className="about-image">
            <img src={imageUrl} alt="Profile" />
          </div>
          <div className="about-text">
            <h3 className="about-name">{about.name}</h3>
            <p className="about-designation">{about.designation}</p>
            <p className="about-description">{about.bio || about.description}</p>
            
            <div className="about-details">
              {about.email && (
                <div className="detail-item">
                  <span className="detail-label">Email:</span>
                  <a href={`mailto:${about.email}`}>{about.email}</a>
                </div>
              )}
              {about.phone && (
                <div className="detail-item">
                  <span className="detail-label">Phone:</span>
                  <a href={`tel:${about.phone}`}>{about.phone}</a>
                </div>
              )}
              {about.location && (
                <div className="detail-item">
                  <span className="detail-label">Location:</span>
                  <span>{about.location}</span>
                </div>
              )}
            </div>

            <div className="about-links">
              {about.githubUrl && (
                <a href={about.githubUrl} target="_blank" rel="noopener noreferrer" className="social-link github">
                  GitHub
                </a>
              )}
              {about.linkedinUrl && (
                <a href={about.linkedinUrl} target="_blank" rel="noopener noreferrer" className="social-link linkedin">
                  LinkedIn
                </a>
              )}
              {about.leetcodeUrl && (
                <a href={about.leetcodeUrl} target="_blank" rel="noopener noreferrer" className="social-link leetcode">
                  LeetCode
                </a>
              )}
            </div>
          </div>
        </div>
      </div>
    </section>
  );
}
