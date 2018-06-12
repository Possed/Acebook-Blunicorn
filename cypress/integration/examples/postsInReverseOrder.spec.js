context('Post Order', () => {

    beforeEach(() => {
        cy.visit('http://localhost:8080');
        cy.get("#newPost").type("Posted First");
        cy.get("#postForm").submit();
        cy.wait(1000);
        cy.get("#newPost").type("Posted Second");
        cy.get("#postForm").submit();
        cy.wait(1000);
    })

    it('Displays posts in reverse chronological order', () => {
        cy.get(".post-content").first().contains("Posted Second");
    })

    it('Displays posts in reverse chronological order', () => {
        cy.get(".posts-items:nth-of-type(2)").first().contains("Posted Second");
    })
})