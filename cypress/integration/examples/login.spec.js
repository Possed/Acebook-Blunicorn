context('Logging in and out', () => {

    beforeEach(() => {
        cy.visit('http://localhost:8080');
    })

    it('allows you to login', () => {
        cy.get('input[name=username]').type("admin");
        cy.get('input[name=password').type("password");
        cy.get('#loginForm').submit();
        cy.title().should('equal', "Acebook");
    })

    it('fails to log in a new user', () => {
        cy.get('input[name=username]').type("badmin");
        cy.get('input[name=password').type("notpassword");
        cy.get('#loginForm').submit();
        cy.title().should('equal', "Login");
    })

    it('redirrects you to the registration page', () => {
        cy.get('#registerLink').submit()
        cy.title().should('equal', "Register");
    })

})