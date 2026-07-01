import { useState, useEffect } from 'react';
import { getAllEducation } from '../services/api';
import '../styles/Education.css';

export default function Education() {
  const [education, setEducation] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    const fetchEducation = async () => {
      try {
        const data = await getAllEducation();
        setEducation(Array.isArray(data) ? data : data?.data || data?.education || []);
      } catch (err) {
        setError(err.message);
      } finally {
        setLoading(false);
      }
    };

    fetchEducation();
  }, []);

  if (loading) return <div className="section-loading">Loading education...</div>;
  if (error) return <div className="section-error">Error: {error}</div>;

  return (
    <section id="education" className="education-section">
      <div className="container">
        <h2 className="section-title">Education</h2>
        <div className="education-grid">
          {education.map((edu, idx) => {
            const gradeValue = edu.cgpa ?? edu.gpa ?? edu.cgpa_or_percent;
            const gradeLabel = edu.cgpa_or_percent ? 'CGPA/Percentage' : 'CGPA';

            return (
              <div key={idx} className="education-card">
                <h3 className="degree">{edu.degree || edu.program || 'Degree'}</h3>
                <p className="institution">{edu.institution || edu.school || 'Institution'}</p>
                <p className="field">{edu.fieldOfStudy || edu.field || edu.major || 'Field of Study'}</p>
                <p className="graduation-year">
                  {edu.startYear || edu.fromYear ? `${edu.startYear || edu.fromYear} — ${edu.endYear || edu.toYear || 'Present'}` : edu.graduationYear}
                </p>
                {gradeValue && <p className="gpa">{gradeLabel}: {gradeValue}</p>}
              </div>
            );
          })}
        </div>
      </div>
    </section>
  );
}
