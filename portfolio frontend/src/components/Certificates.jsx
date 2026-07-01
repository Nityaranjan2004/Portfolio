import { useState, useEffect } from 'react';
import { getAllCertificates } from '../services/api';
import '../styles/Certificates.css';
import isroLogo from '../assets/isro.jpg';
import pwLogo from '../assets/pw.png';
import teluskoLogo from '../assets/telusko.jpeg';

const CERTIFICATE_LOGOS = {
  isro: isroLogo,
  pw: pwLogo,
  telusko: teluskoLogo,
};

export default function Certificates() {
  const [certificates, setCertificates] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    const fetchCertificates = async () => {
      try {
        const data = await getAllCertificates();
        setCertificates(Array.isArray(data) ? data : data?.data || data?.certificates || []);
      } catch (err) {
        setError(err.message);
      } finally {
        setLoading(false);
      }
    };

    fetchCertificates();
  }, []);

  if (loading) return <div className="section-loading">Loading certificates...</div>;
  if (error) return <div className="section-error">Error: {error}</div>;

  return (
    <section id="certificates" className="certificates-section">
      <div className="container">
        <h2 className="section-title">Certificates</h2>
        <div className="certificates-grid">
          {certificates.map((cert, idx) => {
            const key = cert.issuer?.toLowerCase?.() || cert.name?.toLowerCase?.() || '';
            const logo = CERTIFICATE_LOGOS.isro;
            const logoKey = key.includes('isro') ? 'isro' : key.includes('pw') ? 'pw' : key.includes('telusko') ? 'telusko' : '';
            return (
              <div key={idx} className="certificate-card">
                <div className="certificate-header">
                  {logoKey && (
                    <img src={CERTIFICATE_LOGOS[logoKey]} alt={`${logoKey} logo`} className="certificate-logo" />
                  )}
                  <h3 className="certificate-title">{cert.name}</h3>
                </div>
                <p className="certificate-issuer">{cert.issuer}</p>
                <p className="certificate-date">{cert.issueDate}</p>
                {cert.credentialUrl && (
                  <a href={cert.credentialUrl} target="_blank" rel="noopener noreferrer" className="view-credential">
                    View Credential
                  </a>
                )}
              </div>
            );
          })}
        </div>
      </div>
    </section>
  );
}
