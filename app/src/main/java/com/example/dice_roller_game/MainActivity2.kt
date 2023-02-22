package com.example.dice_roller_game

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast


class MainActivity2 : AppCompatActivity() {
    private var score: Int = 0
    private var currentPlayer: Int = 1
    private lateinit var scoreTextView: TextView
    private lateinit var currentPlayerTextView: TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        scoreTextView = findViewById(R.id.current_score_text_view)
        currentPlayerTextView = findViewById(R.id.current_player_text_view)

        val player1RollButton = findViewById<Button>(R.id.player1_roll_button)
        player1RollButton.setOnClickListener {
            rollDice()
            currentPlayer = 2
            currentPlayerTextView.text = "Current Player: Player 2"
        }

        val player2RollButton = findViewById<Button>(R.id.player2_roll_button)
        player2RollButton.setOnClickListener {
            rollDice()
            currentPlayer = 1
            currentPlayerTextView.text = "Current Player: Player 1"
        }

    }
    private fun rollDice() {
        val randomInt = (1..6).random()
        score += randomInt
        scoreTextView.text = "Current Score: $score"
        if (score >= 101) {
            gameOver()
        }
    }

    private fun gameOver() {
        Toast.makeText(this, "Player $currentPlayer wins!", Toast.LENGTH_LONG).show()
        score = 0
        currentPlayer = 1
        scoreTextView.text = "Current Score: $score"
        currentPlayerTextView.text = "Current Player: Player 1"
    }



}