context('Logging in and out', () => {

    beforeEach(() => {
        cy.visit('http://localhost:8080');
        cy.get('#registerLink').click()
    })

    it('allows you to Register', () => {
        cy.get('#username').type("user1");
        cy.get('#email').type("email@email.com");
        cy.get('#password').type("password1");
        cy.get('#registerForm').submit();
        cy.contains("You've successfully registered to Acebook!")
    })

    it('fails to Register an existing username', () => {
        cy.get('#username').type("admin");
        cy.get('#email').type("new@email.com");
        cy.get('#password').type("password2");
        cy.get('#registerForm').submit();
        cy.contains("There is already an account registered with those details")
    })

    it('fails to Register an existing email', () => {
        cy.get('#username').type("newname");
        cy.get('#email').type("admin@acebook.com");
        cy.get('#password').type("password3");
        cy.get('#registerForm').submit();
        cy.contains("There is already an account registered with those details")
    })

    it('fails to login if username blank', () => {
        cy.get('#email').type("anew@email.com");
        cy.get('#password').type("password3");
        cy.get('#registerForm').submit();
        cy.contains("must not be empty");
    })

    it('fails to login if email blank', () => {
        cy.get('#username').type("user2");
        cy.get('#password').type("password3");
        cy.get('#registerForm').submit();
        cy.contains("must not be empty");
    })

    it('fails to login if email blank', () => {
        cy.get('#username').type("user2");
        cy.get('#email').type("email@email.com");
        cy.get('#registerForm').submit();
        cy.contains("must not be empty");
     })

    it('fails to not a valid email', () => {
        cy.get('#username').type("user2");
        cy.get('#email').type("email");
        cy.get('#password').type("password");
        cy.get('#registerForm').submit();
        cy.contains("must be a well-formed email address");
    })

    it('redirects you to the login page', () => {
        cy.get('#loginLink').click()
        cy.title().should('equal', "Login");
    })

})