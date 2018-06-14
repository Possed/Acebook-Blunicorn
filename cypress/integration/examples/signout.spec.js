context('Logging in and out', () => {

    beforeEach(() => {
        cy.visit('http://localhost:8080');
        cy.get('input[name=username]').type("admin");
        cy.get('input[name=password').type("password");
        cy.get('#loginForm').submit();
    })

    it('allows you to login', () => {
        cy.get('#logoutForm').submit();
        cy.title().should('equal', "Login");
    })

})