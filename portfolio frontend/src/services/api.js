const BASE_URL = import.meta.env.VITE_API_URL

// About
export const getAboutInfo = async () => {
  try {
    const response = await fetch(`${BASE_URL}/about`);
    if (!response.ok) throw new Error('Failed to fetch about info');
    return await response.json();
  } catch (error) {
    console.error('Error fetching about info:', error);
    throw error;
  }
};

// Skills
export const getAllSkills = async () => {
  try {
    const response = await fetch(`${BASE_URL}/skills`);
    if (!response.ok) throw new Error('Failed to fetch skills');
    return await response.json();
  } catch (error) {
    console.error('Error fetching skills:', error);
    throw error;
  }
};

export const getSkillsByCategory = async (category) => {
  try {
    const response = await fetch(`${BASE_URL}/skills/category/${category}`);
    if (!response.ok) throw new Error('Failed to fetch skills by category');
    return await response.json();
  } catch (error) {
    console.error('Error fetching skills by category:', error);
    throw error;
  }
};

// Projects
export const getAllProjects = async () => {
  try {
    const response = await fetch(`${BASE_URL}/projects`);
    if (!response.ok) throw new Error('Failed to fetch projects');
    return await response.json();
  } catch (error) {
    console.error('Error fetching projects:', error);
    throw error;
  }
};

// Experiences
export const getAllExperiences = async () => {
  try {
    const response = await fetch(`${BASE_URL}/experiences`);
    if (!response.ok) throw new Error('Failed to fetch experiences');
    return await response.json();
  } catch (error) {
    console.error('Error fetching experiences:', error);
    throw error;
  }
};

// Education
export const getAllEducation = async () => {
  try {
    const response = await fetch(`${BASE_URL}/education`);
    if (!response.ok) throw new Error('Failed to fetch education');
    return await response.json();
  } catch (error) {
    console.error('Error fetching education:', error);
    throw error;
  }
};

// Certificates
export const getAllCertificates = async () => {
  try {
    const response = await fetch(`${BASE_URL}/certificates`);
    if (!response.ok) throw new Error('Failed to fetch certificates');
    return await response.json();
  } catch (error) {
    console.error('Error fetching certificates:', error);
    throw error;
  }
};

// Contact
export const sendContactMessage = async (contactData) => {
  try {
    const response = await fetch(`${BASE_URL}/contact`, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(contactData),
    });
    if (!response.ok) throw new Error('Failed to send contact message');
    return await response.json();
  } catch (error) {
    console.error('Error sending contact message:', error);
    throw error;
  }
};
