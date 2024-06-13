;;; Sierra Script 1.0 - (do not remove this comment)
(script# 385)
(include sci.sh)
(use Main)
(use LLRoom)
(use n958)
(use Sound)
(use Cycle)
(use PicView)
(use Obj)

(public
	rm385 0
)

(local
	local0
	local1
	theTicks
	local3
)
(instance rm385 of LLRoom
	(properties
		picture 385
		style $000e
	)
	
	(method (init)
		(super init:)
		(proc958_0 132 387)
		(= local1 10)
		(cloud
			init:
			setStep: local1 local1
			posn: (Random 250 255) 199
			setMotion: MoveTo (cloud x?) 14 cloud
		)
		(body init: setCycle: Fwd)
		(head init: setCycle: Fwd)
		(gLongSong number: 386 loop: -1 play:)
		(gLongSong2 number: 390 loop: -1 play: global2)
		(theMusic3 number: 387 loop: -1 play:)
		(global2 setScript: sDyingInFirstClass)
		(proc0_13 1000 global2)
	)
	
	(method (cue)
		(global2 newRoom: 390)
	)
	
	(method (newRoom)
		(gLl5Timer dispose: delete:)
		(super newRoom: &rest)
	)
)

(instance cloud of Actor
	(properties
		x 255
		y 189
		view 385
		priority 1
		signal $4810
	)
	
	(method (cue)
		(switch (++ local0)
			(1
				(proc0_17 (Random 3 7) 1 self)
			)
			(2
				(if (< local1 44) (= local1 (+ local1 2)))
				(cloud
					setStep: local1 local1
					posn: (Random 250 255) 199
					setMotion: MoveTo (cloud x?) 14 self
				)
				(= local0 0)
			)
		)
	)
)

(instance head of Prop
	(properties
		x 215
		y 78
		view 386
		loop 1
		priority 14
		signal $4810
	)
)

(instance body of Prop
	(properties
		x 173
		y 146
		view 386
		priority 10
		signal $4810
	)
)

(instance theMusic3 of Sound
	(properties)
)

(instance sDyingInFirstClass of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (proc0_2) (= seconds 6))
			(1 (proc0_14 385 0 108 self))
			(2 (= ticks 30))
			(3 (proc0_14 385 1 108 self))
			(4 (= ticks 30))
			(5 (proc0_14 385 2 108 self))
			(6 (= ticks 30))
			(7 (proc0_14 385 3 108 self))
			(8
				(= ticks 30)
				(= register 64)
			)
			(9
				(if (proc0_6 register)
					(= cycles 1)
					(= theTicks 2)
				else
					(switch register
						(81
							(proc0_18 gLarry 385 4 108 self)
							(= local3 1)
							(= theTicks 30)
						)
						(85
							(proc0_18 gLarry 385 5 108 self)
							(= local3 1)
							(= theTicks 30)
						)
						(86
							(proc0_18 gLarry 385 6 108 self)
							(= local3 1)
							(= theTicks 30)
						)
						(87
							(proc0_18 gLarry 385 7 108 self)
							(= local3 1)
							(= theTicks 30)
						)
						(74
							(proc0_18 gLarry 385 8 108 self)
							(= local3 1)
							(= theTicks 30)
						)
						(68
							(proc0_18 gLarry 385 9 108 self)
							(= local3 1)
							(= theTicks 30)
						)
						(142
							(proc0_18 gLarry 385 10 108 self)
							(= local3 1)
							(= theTicks 30)
						)
						(161
							(proc0_18 gLarry 385 11 108 self)
							(= local3 1)
							(= theTicks 30)
						)
						(164
							(proc0_18 gLarry 385 12 108 self)
							(= local3 1)
							(= theTicks 30)
						)
						(166
							(proc0_18 gLarry 385 13 108 self)
							(= local3 1)
							(= theTicks 30)
						)
						(165
							(proc0_18 gLarry 385 14 108 self)
							(= local3 1)
							(= theTicks 30)
						)
						(167
							(proc0_18 gLarry 385 15 108 self)
							(= local3 1)
							(= theTicks 30)
						)
						(116
							(proc0_18 gLarry 385 16 108 self)
							(= local3 1)
							(= theTicks 30)
						)
						(117
							(proc0_18 gLarry 385 17 108 self)
							(= local3 1)
							(= theTicks 30)
						)
						(136
							(proc0_18 gLarry 385 18 108 self)
							(= local3 1)
							(= theTicks 30)
						)
						(137
							(proc0_18 gLarry 385 19 108 self)
							(= local3 1)
							(= theTicks 30)
						)
						(else 
							(= theTicks 2)
							(= cycles 1)
						)
					)
				)
			)
			(10
				(if (< (++ register) 168) (= state (- state 2)))
				(= ticks theTicks)
			)
			(11
				(if local3
					(= cycles 1)
				else
					(proc0_18 gLarry 385 20 108 self)
				)
			)
			(12 (= ticks 60))
			(13 (proc0_14 385 21 108 self))
			(14 (= ticks 60))
			(15
				(proc0_14
					385
					22
					67
					-1
					185
					70
					280
					80
					{Palubní rozhlas}
					108
					self
				)
			)
			(16 (= ticks 60))
			(17
				(proc0_18 gLarry 385 23 108 self)
			)
			(18 (= ticks 60))
			(19
				(proc0_18 gLarry 385 24 108 self)
			)
			(20 (= ticks 60))
			(21
				(proc0_14 385 25 80 {Letuška} 108 self)
			)
			(22
				(proc0_14 385 26 80 {Letuška} 108 self)
			)
			(23 (= ticks 60))
			(24
				(proc0_18 gLarry 385 27 108 self)
			)
			(25 (= ticks 60))
			(26
				(proc0_14 385 28 80 {Letuška} 108 self)
			)
			(27 (global2 newRoom: 390))
		)
	)
)
