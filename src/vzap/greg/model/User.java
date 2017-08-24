package vzap.greg.model;

public class User
{
	private String name = null;
	private String email = null;
	private String username = null;
	private String password = null;
	
	public User ()
	{
		
	}

	public String getName()
	{
		return this.name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getEmail()
	{
		return this.email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getUsername()
	{
		return this.username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getPassword()
	{
		return this.password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.password == null) ? 0 : this.password.hashCode());
		result = prime * result + ((this.username == null) ? 0 : this.username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (this.password == null)
		{
			if (other.password != null)
				return false;
		}
		else if (!this.password.equals(other.password))
			return false;
		if (this.username == null)
		{
			if (other.username != null)
				return false;
		}
		else if (!this.username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString()
	{
		return "User [name=" + this.name + ", email=" + this.email + ", username=" + this.username + ", password="
				+ this.password + "]";
	}
}
