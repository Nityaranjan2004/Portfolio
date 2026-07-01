import { useState, useEffect } from 'react';
import { getAllExperiences } from '../services/api';
import '../styles/Experience.css';

export default function Experience() {
  const [experiences, setExperiences] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    const fetchExperiences = async () => {
      try {
        const data = await getAllExperiences();
        setExperiences(Array.isArray(data) ? data : data?.data || data?.experiences || []);
      } catch (err) {
        setError(err.message);
      } finally {
        setLoading(false);
      }
    };

    fetchExperiences();
  }, []);

  if (loading) return <div className="section-loading">Loading experiences...</div>;
  if (error) return <div className="section-error">Error: {error}</div>;

  return (
    <section id="experience" className="experience-section">
      <div className="container">
        <h2 className="section-title">Experience</h2>
        <div className="experience-timeline">
          {experiences.map((exp, idx) => (
            <div key={idx} className="timeline-item">
              <div className="timeline-dot"></div>
              <div className="timeline-content">
                <h3 className="job-title">{exp.title}</h3>
                <p className="company-name">{exp.company}</p>
                <p className="employment-period">
                  {exp.startDate} - {exp.endDate || 'Present'}
                </p>
                <p className="job-description">{exp.description}</p>
              </div>
            </div>
          ))}
        </div>
      </div>
    </section>
  );
}
