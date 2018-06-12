context('TimeStamp', () => {

    var today;
    var month;
    var day;
    var year;

    beforeEach(() => {
        cy.visit('http://localhost:8080');
        today = new Date();
        month = today.getMonth()+1;
        day = today.getDate();
        year = today.getFullYear();

        if (month < 10) month = '0' + month;
        if (day < 10) day = '0' + day;
    })

    it('Shows the time that the post was created', () => {
        cy.contains(`${year}-${month}-${day}`)
    })
})