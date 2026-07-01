import { useState, useEffect } from 'react';
import { getAllProjects } from '../services/api';
import '../styles/Projects.css';

export default function Projects() {
  const [projects, setProjects] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    const fetchProjects = async () => {
      try {
        const data = await getAllProjects();
        setProjects(Array.isArray(data) ? data : data?.data || data?.projects || []);
      } catch (err) {
        setError(err.message);
      } finally {
        setLoading(false);
      }
    };

    fetchProjects();
  }, []);

  if (loading) return <div className="section-loading">Loading projects...</div>;
  if (error) return <div className="section-error">Error: {error}</div>;

  return (
    <section id="projects" className="projects-section">
      <div className="container">
        <h2 className="section-title">Projects</h2>
        <div className="projects-grid">
          {projects.map((project, idx) => {
            const githubUrl = project.github || project.githubUrl || project.github_url || project.githubLink || project.githubLink || project.repo;
            const liveUrl = project.live || project.liveUrl || project.live_url || project.liveLink || project.website || project.liveUrl;
            const techs = Array.isArray(project.technologies)
              ? project.technologies
              : project.techStack
                ? project.techStack.split(',').map(t => t.trim())
                : project.techstack
                  ? project.techstack.split(',').map(t => t.trim())
                  : [];

            return (
              <div key={idx} className="project-card">
                {project.image && (
                  <div className="project-image">
                    <img src={project.image} alt={project.title} />
                  </div>
                )}
                <div className="project-content">
                  <h3 className="project-title">{project.title}</h3>
                  <p className="project-description">{project.description}</p>
                  {techs.length > 0 && (
                    <div className="project-tech">
                      {techs.map((tech, i) => (
                        <span key={i} className="tech-tag">{tech}</span>
                      ))}
                    </div>
                  )}
                  <div className="project-links">
                    {githubUrl && (
                      <a href={githubUrl} target="_blank" rel="noopener noreferrer" className="btn-link">
                        GitHub
                      </a>
                    )}
                    {liveUrl && (
                      <a href={liveUrl} target="_blank" rel="noopener noreferrer" className="btn-link">
                        Live Demo
                      </a>
                    )}
                  </div>
                </div>
              </div>
            );
          })}
        </div>
      </div>
    </section>
  );
}
